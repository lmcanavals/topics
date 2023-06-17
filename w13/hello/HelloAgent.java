import jade.core.Agent;

/**
 * https://www.iro.umontreal.ca/~vaucher/Agents/Jade/primer2.html
 *
 */
public class HelloAgent extends Agent
{
	protected void setup() {
		System.out.println("Hello, World.");
		System.out.println("My name is " + getLocalName());
	}
}
