package com.te.mms.entity;

public enum Unit {
	Billions("Billions"), Millions("Millions"), Thousands("Thousands");

	private String message;

	Unit(String message) {
		this.message = message;
	}
}
