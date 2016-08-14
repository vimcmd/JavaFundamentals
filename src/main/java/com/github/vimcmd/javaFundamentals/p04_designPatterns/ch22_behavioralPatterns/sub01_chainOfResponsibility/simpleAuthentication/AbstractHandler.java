package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.simpleAuthentication;

// # 3 # Default handler

public abstract class AbstractHandler {

    protected MapEmployee db;
    protected AbstractHandler successor = DefaultHandleRequest.getHandleRequest();

    public AbstractHandler(AbstractHandler successor) {
        this.db = new MapEmployee();
        this.successor = successor;
    }

    public AbstractHandler() {
        this.db = new MapEmployee();
    }

    public void setSuccessor(AbstractHandler successor) {
        this.successor = successor;
    }

    abstract public void handleRequest(Employee employee);

    public void chain(Employee user) {
        if (db.containsUser(user)) {
            handleRequest(user);
            successor.chain(user);
        } else {
            System.out.println("User does not exists.");
        }
    }

    private static class DefaultHandleRequest extends AbstractHandler {

        private static DefaultHandleRequest handler = new DefaultHandleRequest();

        private DefaultHandleRequest() {
        }

        public static DefaultHandleRequest getHandleRequest() {
            return handler;
        }

        @Override
        public void chain(Employee user) {
            // always empty
        }

        @Override
        public void handleRequest(Employee employee) {
            // default handler if exists
        }
    }
}
