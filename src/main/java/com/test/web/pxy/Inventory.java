package com.test.web.pxy;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Inventory<T> {
	private ArrayList<T> inventory;
	
	public Inventory() {
		inventory = new ArrayList<>();
	}
	public void add(T t) {
		//inventory = new ArrayList<>();
		inventory.add(t);
	}
	public void clear() {
		inventory.clear();
		
	}
	public T get(int i ) {
		return inventory.get(i);
		
	}
	public ArrayList<T> get(){
		return inventory;
		
	}
}
