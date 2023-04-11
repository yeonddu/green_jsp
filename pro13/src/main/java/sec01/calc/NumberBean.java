package sec01.calc;

public class NumberBean {
	private String num1;
	private String op;
	private String num2;
	private int value;

	public NumberBean(){
	}

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public int getValue() {
		
		 
		return value;
	}
	public int calc() {
		
		switch(op){ 
		case "+" : value = Integer.parseInt(num1)+Integer.parseInt(num2);break; 
		case "-" : value = Integer.parseInt(num1)-Integer.parseInt(num2);break; 
		case "*" : value = Integer.parseInt(num1)*Integer.parseInt(num2);break; 
		case "/" : value = Integer.parseInt(num1)/Integer.parseInt(num2);break; 
		}
		return value;
	}
	public void setValue(int value) {
		value = calc();
		this.value = value;
	}	
	
	
}
