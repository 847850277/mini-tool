package com.zp.reactor.core;

import reactor.core.publisher.Flux;

import java.util.List;

public class HelloWorld5 {

    public static interface MyEventListener<T>{
        void onDataChunk(List<T> chunk);

        void processComplete();
    }

    public static class SingleThreadEventListener implements MyEventListener{

        @Override
        public void onDataChunk(List chunk) {
        }

        @Override
        public void processComplete() {

        }
    }

    public static class myEventProcessor{

        public static void register(MyEventListener<String> myEventListener) {

        }
    }

    public static void main(String[] args) {

        Flux<String> bridge = Flux.create(sink -> {
            myEventProcessor.register(
                    new MyEventListener<String>() {

                        public void onDataChunk(List<String> chunk) {
                            for(String s : chunk) {
                                sink.next(s);
                            }
                        }

                        public void processComplete() {
                            sink.complete();
                        }
                    });
        });


        // push模式

        Flux bridge1 = Flux.push(sink -> {
            myEventProcessor.register(
                    new SingleThreadEventListener() {

                        public void onDataChunk(List chunk) {
                            for(Object s : chunk) {
                                sink.next(s);
                            }
                        }

                        public void processComplete() {
                            sink.complete();
                        }

                        public void processError(Throwable e) {
                            sink.error(e);
                        }
                    });
        });



    }


}


