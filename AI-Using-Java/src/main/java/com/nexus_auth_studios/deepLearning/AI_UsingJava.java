package com.nexus_auth_studios.deepLearning;

import ai.djl.Model;
import ai.djl.inference.Predictor;
import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDList;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.types.DataType;
import ai.djl.ndarray.types.Shape;
import ai.djl.nn.Activation;
import ai.djl.nn.SequentialBlock;
import ai.djl.nn.core.Linear;
import ai.djl.translate.NoopTranslator;
import ai.djl.translate.TranslateException;

public class AI_UsingJava {
    public static void main(String[] args) {
        SequentialBlock block = new SequentialBlock().add(Linear.builder().setUnits(10).build()).add(Activation::relu).add(Linear.builder().setUnits(2).build());
        try (Model model = Model.newInstance("ai-using-java")) {
            try (NDManager manager = NDManager.newBaseManager()) {
                block.initialize(manager, DataType.FLOAT32, new Shape(1, 3));
                System.out.println("Initialized a neural network model yet to be trained ");


                float[] inputData = new float[]{1.5f, 2.0f, -0.5f};
                NDArray inputTensor = manager.create(inputData, new Shape(1, 3));
                NDList inputList = new NDList(inputTensor);

                try (Predictor<NDList, NDList> predictor = model.newPredictor(new NoopTranslator())) {
                    NDList outputList = predictor.predict(inputList);
                    NDArray outputTensor = outputList.singletonOrThrow();

                    float[] results = outputTensor.toFloatArray();
                    System.out.println("OUTPUT 1:" + results[0]);
                    System.out.println("OUTPUT 1:" + results[1]);
                } catch (TranslateException e) {
                    System.err.println("We're sorry but, the predictor could not translate! :(");
                }
            }
        }
    }
}
