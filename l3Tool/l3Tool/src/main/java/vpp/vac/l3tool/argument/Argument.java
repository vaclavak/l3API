package vpp.vac.l3tool.argument;

import java.util.ArrayList;

public class Argument {

	private String name;

	private ArgumentMethod method;

	public Argument(String name, ArgumentMethod method, ArrayList<Argument> argumentList) {
		this.name = name;
		this.method = method;
		argumentList.add(this);
	}

	public String getName() {
		return this.name;
	}

	public void run() {
		this.method.run();
	}

}
