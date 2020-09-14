package com.nokia.interns.notes.model;

public enum Priority {
    HIGH {
        @Override
        public String toString() {
            return "wysoki";
        }
    }, DEFAULT {
        @Override
        public String toString() {
            return "domyślny";
        }
    }, LOW {
        @Override
        public String toString() {
            return "niski";
        }
    }
}
