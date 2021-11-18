package com.learning.java;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class StackArray<T> implements Stack<T> {

    private int maxSize;
    private T[] array;
    private int top;

    public StackArray(int maxSize) {
        this.maxSize = maxSize;
//        @SuppressWarnings("unchecked")
        this.array = (T[]) Array.newInstance(StackArray.class, maxSize);
        this.top = -1;
    }

    private T[] resizeArray() {
        /**
         * create a new array double the size of the old, copy the old elements then return the new array */
        int newSize = maxSize * 2;
        T[] newArray = (T[]) Array.newInstance(StackArray.class, newSize);
        for(int i = 0; i < maxSize; i++) {
            newArray[i] = this.array[i];
        }
        return newArray;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }

    public void push(T element) {
        if(!this.isFull()) {
            ++top;
            array[top] = element;
        }
        else {
            this.array = resizeArray();
            array[++top] = element;
        }
    }

    public T pop() {
        if(!this.isEmpty())
            return array[top--];
        else {
            throw new EmptyStackException();
        }
    }

    public T peek() {
        return array[top];

}

	@Override
	public void push() {
		// TODO Auto-generated method stub
		
	}
}
