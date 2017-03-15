public class FFNN {
	public static int InputNuerons = 128 * 120;
	public static int HiddenNuerons = 20; //deviced arbitarilaly
	public static int OutputNuerons = 1;
	
	
	public int inputs[] = new int[InputNuerons];
	public int hiddens[] = new int[HiddenNuerons];
	public int Outputs[] = new int[OutputNuerons];
	
	public int weightsOutToHidden[] = new int[OutputNuerons][HiddenNuerons];
	public int weightsHiddenToIn[] = new int[HiddenNuerons][InputNuerons];
	
	public double learningRate = 0.2;
	
	public FFNN(){}
	
	//returns prediction based on input to the network
	public int forwardProp(int[][] inputData){}
	
	public void backProp(){}
	
	public void computeErr(){}
	
	public void gradOuttoHidden(){}
	
	public void gradHiddentoIn(){}
	
	public void updatWeights(){}
	
	public void train(){}
	
	public void test(){}

    public void hello(){
        System.out.println("Hello, World");
    }

}
