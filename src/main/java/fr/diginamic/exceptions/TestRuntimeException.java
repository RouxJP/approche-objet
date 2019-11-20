package fr.diginamic.exceptions;

public class TestRuntimeException {

	public TestRuntimeException() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		try {
			System.out.println( Operation.diviserRuntime(12.12, 24.24));
			System.out.println( Operation.diviserRuntime(12.12, 48.24));
			System.out.println( Operation.diviserRuntime(12.12, 0));
			
		} catch (RuntimeException e) {
			System.out.println( e.getMessage());
		}

	}

}
