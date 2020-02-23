class PDnC extends Polynom {

    public PDnC(PBF p) {
    	super(p);
    }

    public PDnC(int ord) {
    	super(ord);
    }

    public PDnC(PDnC p, int s, int e) {
    	super(p,s,e);
    }

    public PDnC(int ord, boolean isEmpty) {
    	super(ord,isEmpty);
    }

	public PDnC Sum (PDnC p) {
		PDnC pt = new PDnC(order);
		for (int i = 0; i < order; i++) {
			pt.mem[i] = mem[i]+p.mem[i];
			pt.s += 1;
		}
		pt.mem[order] = mem[order];
		if (p.order == order) {
			pt.mem[order] += p.mem[order];
			pt.s += 1;
		}
		return pt;
	}

	/* Proses Combine (step 5) */
	public PDnC Combine (PDnC y, PDnC u, PDnC z, int e, int m) {
		PDnC pt = new PDnC(e*2,true);
		pt.s += u.s + z.s + y.s;
		pt.m += u.m + z.m + y.m;
		for (int i = 0; i <= z.order; i++) {
			pt.mem[i+m] += y.mem[i] - u.mem[i] - z.mem[i];
			pt.mem[i] += u.mem[i];
			pt.mem[i+m*2] += z.mem[i];
			pt.s += 5;
		}
		for (int i = z.order+1; i <= y.order; i++) {
			pt.mem[i+m] += y.mem[i] - u.mem[i];
			pt.mem[i] += u.mem[i];
			pt.s += 3;
		}
		return pt;
	}

    public PDnC Mx (PDnC p1, PDnC p2) {
    	int e = p1.order, m = e/2;
    	// Step 1
    	if (e == 0) {
    		PDnC pt = new PDnC(0);
    		pt.mem[0] = p1.mem[e]*p2.mem[e];
    		pt.m += 1 + p1.m + p2.m;
    		pt.s += p1.s + p2.s;
	    	return pt;
    	} else {
    		// Step 2
	    	PDnC l1 = new PDnC(p1,0,m),
	    		h1 = new PDnC(p1,m+1,e),
	    		l2 = new PDnC(p2,0,m),
	    		h2 = new PDnC(p2,m+1,e);
    		// Step 3 & 4
	    	PDnC y = Mx(l1.Sum(h1),l2.Sum(h2));
	    	PDnC u = Mx(l1,l2);
	    	PDnC z = Mx(h1,h2);
    		// Step 5
	    	return Combine(y,u,z,e,m+1);
	    }
    }

}