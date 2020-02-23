class PBF extends Polynom {

    public PBF(int ord) {
        super(ord);
    }

    public PBF(PDnC p) {
        super(p,0,p.order);
    }

    public PBF(int ord, boolean isEmpty) {
        super(ord,isEmpty);
    }

    public PBF Mx (PBF p) {
        // Step 1
    	PBF pt = new PBF(order*2,true);
        // Loop untuk mencari semua kemungkinan pasangan
    	for (int i = 0; i <= order; i++) for (int j = 0; j <= order; j++) {
            // Step 2
    		pt.mem[i+j] += mem[i]*p.mem[j];  
    		pt.m += 1;
    		pt.s += 1;
    	}
        // Step 3
    	return pt;
    }

}