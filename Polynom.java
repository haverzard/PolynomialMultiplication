import java.io.*; 
import java.util.Random;
import java.util.ArrayList;

class Polynom {
	
	public int order;
    public int[] mem;
    public int m = 0;
    public int s = 0;

    public Polynom(PBF p) {
    	order = p.order;
    	mem = new int[order+1];
    	for (int i = 0; i <= order; i++) mem[i] = p.mem[i];
    }

    public Polynom(PDnC p, int s, int e) {
    	order = e-s; mem = new int[order+1];
    	for (int i = 0; i <= order; i++) mem[i] = p.mem[i+s];
    }

    public Polynom(int ord) {
    	order = ord;
    	mem = new int[order+1];
    }

    public Polynom(int ord, boolean isEmpty) {
    	order = ord;
    	mem = new int[order+1];
    	if (!isEmpty) {
	    	Random random = new Random();
		    for (int i = 0; i <= order; i++) mem[i] = random.nextInt(100)-50;
		} else for (int i = 0; i <= order; i++) mem[i] = 0;
    }

    public void ShowPoly () {
		String out = ""; int neg = 1;
	    if (mem[0] < 0) { out += "- "; neg = -1;}
	    out += mem[0]*neg;
		for (int i = 1; i <= order; i++)
	    {
            if (mem[i] != 0) {
		    	if (mem[i] >= 0) { out += " + "; neg = 1; } 
		    	else { out += " - "; neg = -1; }
			    out += mem[i]*neg+"x^"+i;
			}
	    }
	    System.out.println(out);
    }

    public void ShowM () {
    	System.out.println("Penjumlahan : "+s);
    	System.out.println("Perkalian   : "+m);
    }

}