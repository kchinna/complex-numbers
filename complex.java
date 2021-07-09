/*
* COMPLEX CLASS
*
* This class provides a variety of methods and features
* to deal with complex numbers
*
* Kanishk Chinna
*/
public class complex
{
	private double a; //represents real number
	private double b; //represents imaginary coefficient

	//CONSTRUCTORS: sets values in complex class for when we call it
	public complex(double x, double y, boolean z)
	{
		if(z == true) //if true then (a, b) = complex number
		{
			a = x;
			b = y;
		}
		else //if false then (mag, arg) = polar coordinate
		{
			//get complex number from polar coordinates
			a = Math.cos(y) * x;
			b = Math.sin(y) * x;
		}
	}
	public complex(double x, double y) //no boolean so defaults to (a, b)
	{
		a = x;
		b = y;
	}
	public complex(double x) //only one input so defaults to (x, 0), where a = x, b = 0
	{
		this(x, 0);
	}
	public complex() //no input so it defaults to (0, 0) where a and b = 0
	{
		this(0, 0);
	}
	public complex(complex z) //copies complex z
	{
		a = z.a;
		b = z.b;
	}

	//GETTER METHODS
	public double getRealA() //gets a
	{
		return a;
	}
	public double getImaginaryB() // gets b
	{
		return b;
	}

	//SETTER METHODS
	public void setRealA(double val) //makes a = to inputted value
	{
		a = val;
	}

	public void setImaginaryB(double val) //makes b = inputted value
	{
		b = val;
	}

	/*
	* THETA
	*
	* given a and b from complex number
	*
	* Non Static:
	* @return double This is theta, aka angle between a and b
	*
	* Static:
	* @param complex z Will get a and b values for calculations from this complex number
	* @return double This is theta, aka angle between a and b
	*/
	public double arg()
	{
		//atan2 only returns value from quadrant 1 and 4
		//so if atan2(b,a) = negative... then b = negative
		if(Math.atan2(b,a) < 0 && b > 0) //quadrant 2
		{
			return((Math.PI - Math.atan2(b, a)) + (Math.PI));
		}
		else if(a < 0 && b < 0) //quadrant 3
		{
			return(2 * Math.PI + Math.atan2(b, a));
		}
		else if(b < 0 && Math.atan2(b,a) < 0) //quadrant 4
		{
			return(2 * Math.PI + Math.atan2(b, a));
		}
		return(Math.atan2(b, a)); //quadrant 1
	}
	public static double arg(complex z) //finding theta, but with static method - need to use instance to get a and b
	{
		//System.out.println(Math.atan2(b, a));
		if(Math.atan2(z.b, z.a) < 0 && z.b > 0) //quadrant 2
		{
			return((Math.PI - Math.atan2(z.b, z.a)) + (Math.PI));
		}
		else if(z.a < 0 && z.b < 0) //quadrant 3
		{
			return(2 * Math.PI + Math.atan2(z.b, z.a));
		}
		else if(z.b < 0 && Math.atan2(z.b, z.a) < 0) //quadrant 4
		{
			return(2 * Math.PI + Math.atan2(z.b, z.a));
		}
		return(Math.atan2(z.b, z.a)); //quadrant 1
	}

	/*
	* HYPOTENUSE
	*
	* given a and b from complex number
	*
	* Non Static:
	* @return double This is the hypotenuse, aka r value in polar coordinate
	*
	* Static:
	* @param complex z Will get a and b values for calculations from this complex number
	* @return double This is the hypotenuse, aka r value in polar coordinate
	*/
	public double mag()
	{
		return(Math.sqrt(a*a + b*b));
	}
	public static double mag(complex z)//mag method with paramemter z of type complex: static method
	{
		return(Math.sqrt(z.a*z.a + z.b*z.b));
	}

	//FOLLOWING METHODS ARE BASIC METHODS FOR CLASS

	/*
	* TOSTRING
	*
	* converts complex number in call object to string format
	*
	* @return String Will return complex number in (a, b) format
	*/
	public String toString()
	{
		String ret = "(" + a + ", " + b + ")";
		return(ret);
	}

	/*
	* CHECK EQUALS METHOD
	* 
	* checks if call object is equal to the parameter object
	*
	* @param complex z Will be compared will call object of same type
	* @return boolean True if they are equal, false if not
	*/
	public boolean equals(complex z, double epsilon)
	{
		if(a - z.a <= epsilon && a - z.a >= -epsilon)
		{
			if(b - z.b <= epsilon && b - z.b >= -epsilon)
			{
				return(true);
			}
		}
		return(false);
	}
	
	//FOLLOWING METHODS MODIFY OBJECT

	/*
 	* CONJUGATE METHOD
 	*
	* finds the conjugate of the complex number
	*
	* Non-Static:
	* @param none
	* @return complex
	*
	* Static:
	* @param complex z
	* @return complex
	*/
	public complex conjugate()
	{
		complex ret = new complex(a, b * -1);
		return(ret);
	}
	public static complex conjugate(complex z)
	{
		complex ret = new complex(z.a, z.b * -1);
		return(ret);
	}

	/*
 	* ADDITION METHOD
 	*
	* Non-Static:
	* adds complex number to another
	*
	* @param complex y
	* @return complex
	* 
	* Static:
	* adds complex numbers in parameter together
	*
	* @param complex z
	* @param complex y
	* @return complex
	*/
	public complex add(complex y)
	{
		complex ret = new complex(a + y.a, b + y.b);
		return(ret);
	}
	public static complex add(complex z, complex y)
	{
		complex ret = new complex(z.a + y.a, z.b + y.b);
		return(ret);
	}

	/*
	* SUBTRACTION METHOD
 	*
	* Non-Static:
	* subtracts complex number within parameter from object used to call method
	*
	* @param complex y
	* @return complex
	* 
	* Static:
	* subtracts second complex number in parameter from the first
	*
	* @param complex z
	* @param complex y
	* @return complex
	*/
	public complex subtract(complex y)
	{
		complex ret = new complex(a - y.a, b - y.b);
		return(ret);
	}
	public static complex subtract(complex z, complex y)
	{
		complex ret = new complex(z.a - y.a, z.b - y.b);
		return(ret);
	}

	/*
	* MULTIPLICATION METHOD
	*
	* Non-Static:
	* multiplies call object and complex number within parameter
	*
	* @param complex z
	* @return complex
	*
	* Static
	* multiplies both parameter complex numbers together
	* 
	* @param complex z
	* @param complex y
	* @return complex
	*/
	public complex mult(complex z)
	{
		double a1 = (a*z.a)-(b*z.b); //calculates for a
		double b1 = (a*z.b)+(b*z.a); //calculates for b
		complex ret = new complex(a1, b1);
		return(ret);
	}
	public static complex mult(complex z, complex y)
	{
		double a1 = (z.a*y.a)-(z.b*y.b); //calculates for a
		double b1 = (z.a*y.b)+(z.b*y.a); //calculates for b
		complex ret = new complex(a1, b1);
		return(ret);
	}

	/*
	* DIVISION METHOD
	* 
	* Non-Static:
	* divides call object by complex number within parameter
	* parameter cannot be 0+0i => return 0+0i
	*
	* @param complex z
	* @return complex
	*
	* Static
	* divides first complex number in parameter by the second
	* second parameter cannot be 0+0i => return 0+0i
	* 
	* @param complex z
	* @param complex y
	* @return complex
	*/
	public complex div(complex z)
	{
		if(z.a != 0 || z.b != 0)
		{
			//calculates numerator based on conjugate of complex z (aka denominator)
			double a1 = (a*z.a)-(b*(z.b * -1)); //first part = normal subtraction, for imaginary part, we need to get conjugate
			double b1 = (a*(z.b * -1))+(b*z.a); //first imaginary part = conjugate
			//multiplies denominator by conjugate
			double denominator = (z.a * z.a) - (z.b * (z.b * -1)); //for denominator, only need to multiply real and imaginary portions, others(i) will cancel out
			//for final answer, divides a and b of numerator by denominator
			complex ret = new complex(a1/denominator, b1/denominator);
			return(ret);
		}
		else
		{
			System.out.println("DIVIDE BY 0 ERROR");
			complex ret = new complex();
			return(ret);
		}

	}
	public static complex div(complex z, complex y)
	{
		if(y.a != 0 || y.b != 0)
		{
			//calculates numerator based on conjugate of complex z (aka denominator)
			double a1 = (z.a*y.a)-(z.b*(y.b * -1)); //first part = normal, for i^2 part, we need to get conjugate
			double b1 = (z.a*(y.b * -1))+(z.b*y.a); //first complex #(i part) = conjugate
			//multiplies denominator by conjugate
			double denominator = (y.a * y.a) - (y.b * (y.b * -1)); //for denominator, only need to multiply real and i^2 portions, others(i) will cancel out
			//for final answer, divides a and b of numerator by denominator
			complex ret = new complex(a1/denominator, b1/denominator);
			return(ret);
		}
		else
		{
			System.out.println("DIVIDE BY 0 ERROR");
			complex ret = new complex();
			return(ret);
		}
	}

	/*
	* EXPONENT METHOD
	* 
	* Non-Static:
	* takes call object to the power of a real number
	*
	* @param double power
	* @return complex
	*
	* Static:
	* takes complex object to the power of a real number, both of which are parameters
	*
	* @param complex z This will be taken to the power of a user-inputted number
	* @param double power The call object is taken to the power of this number
	* @return complex
	*/
	public complex powe(double power)
	{
		//z^n = r^n * e^in(theta)
		complex ret = new complex(1, 1);

		double rN = Math.pow(this.mag(), power);
		//System.out.println(this.mag());
		//System.out.println(Math.pow(this.mag(), power));

		double exponent = this.arg() * power;
		//System.out.println(this.arg());
		//System.out.println(this.arg() * power);

		ret.a = rN * Math.cos(exponent);
		//System.out.println(Math.cos(exponent));
		ret.b = rN * Math.sin(exponent);
		return(ret);

	}
	public static complex powe(complex z, double power) //principal: a^b = e^(b ln(a)) - https://math.stackexchange.com/questions/21381/how-to-calculate-a-decimal-power-of-a-number
	{
		//z^n = r^n * e^in(theta)
		complex ret = new complex(1, 1);

		double rN = Math.pow(z.mag(), power);
		//System.out.println(this.mag());
		//System.out.println(Math.pow(this.mag(), power));

		double exponent = z.arg() * power;
		//System.out.println(this.arg());
		//System.out.println(this.arg() * power);

		ret.a = rN * Math.cos(exponent);
		//System.out.println(Math.cos(exponent));
		ret.b = rN * Math.sin(exponent);
		return(ret);
	}

	/*
	* ALL ROOTS FINDER METHOD
	*
	* use principle that (a+bi)^1/n = r^(1/n) * e^i * [(theta + 2kpi) / n]
	* where k increments till k = n -1
	* call object is used for theta and r(hypotenuse) values
	*
	* @param int n This is the nth root (n in 1/n)
	* @return complex[] This is an array of all the roots of the complex number
	*/
	public complex[] kroot(int n) //(a+bi)^1/n
	{
		double r = this.mag(); //r = hypotenuse
		double theta = this.arg(); //theta

		complex[] roots = new complex[n]; //array to store all roots, length = nth root
		double newn = (double) n; //use double in calculations for accuracy
		double useA;
		double useB;

		Double newi; //use double in calculations for accuracy
		for(int i = 0; i < n; i++) //for k = n-1
		{
			//r^(1/n) * e^i * [(theta + 2kpi) / n]
			newi = (double) i;
			useA = Math.pow(r, 1/newn) * Math.cos(theta / newn + (2 * Math.PI * newi) / newn);
			useB = Math.pow(r, 1/newn) * Math.sin(theta / newn + (2 * Math.PI * newi) / newn);
			roots[i] = new complex(useA, useB);
		}

		return(roots);
	}

	/*
	* LOG (LN) METHOD
	*
	* uses principle that ln(a + bi) = ln(r) + i(theta)
	* where r is mag and theta is arg
	*
	* @param complex z ln of this
	* @return complex
	*/
	public complex comln()
	{
		//lnr + i(theta)
		double aCoeff = (Math.log(this.mag())); //ln(r)
		double bCoeff = this.arg(); //theta
		complex ret = new complex(aCoeff, bCoeff);
		return(ret);
	}

	/*
	* EXPONENT METHOD WITH 2 COMPLEX NUMBERS
	* 
	* uses principle that z^w = e^wlnz to find one complex number to the power of another
	*
	* @param commplex z This will be taken to the power of other complex number
	* @param complex w This is the power
	* @return complex
	*/
	public complex comPow(complex w)
	{
		//z^w = e^wlnz
		complex ret = (this.comln()).mult(w); //lnz * w
		ret.a = Math.exp(a) * Math.cos(b);
		ret.b = Math.exp(a) * Math.sin(b);
		return(ret);
	}

	/*
	* COSINE METHOD
	* 
	* uses principle that cos(a + bi) = 0.5[e^-b(cosa + isina) + e^b(cos-a + isin-a)]
	*
	* @return complex New complex number is returned
	*/
	public complex comCos()
	{
		complex ret = new complex (1, 1);
		//0.5[e^-b(cosa + isina) + e^b(cos-a + isin-a)]
		double firstA = Math.exp(-b) * Math.cos(a); //e^-b(cosa)
		double firstB = Math.exp(-b) * Math.sin(a); //e^-b(isina)
		double secondA = Math.exp(b) * Math.cos(-a); //e^b(cos-a)
		double secondB = Math.exp(b) * Math.sin(-a); //e^b(isin-a)
		ret.a = 0.5 * (firstA + secondA);
		ret.b = 0.5 * (firstB + secondB);
		return(ret);
	}

	/*
	* SINE METHOD
	* 
	* uses principle that sin(a + bi) = (1/2i)[e^-b(cosa + isina) - e^b(cos-a + isin-a)]
	*
	* @return complex
	*/
	public complex comSin()
	{
		complex ret = new complex(1, 1);
		//(1/2i)[e^-b(cosa + isina) - e^b(cos-a + isin-a)]
		double firstA = Math.exp(-b) * Math.cos(a); //e^-b(cosa)
		double firstB = Math.exp(-b) * Math.sin(a); //e^-b(isina)
		double secondA = Math.exp(b) * Math.cos(-a); //e^b(cos-a)
		double secondB = Math.exp(b) * Math.sin(-a); //e^b(isin-a)
		ret.a = firstA - secondA;
		ret.b = firstB - secondB;
		complex divisor = new complex(0, 2); //used to divide
		return(ret.div(divisor));
	}

	/*
	* INVERSE SINE METHOD
	* 
	* uses principle that sin(w) = z --> arcsin(z) = w
	* sin(w) = (e^(iw)-e^(-iw))/(2i) = z
	* w = w = -i*ln(iz + (1-z^2)^0.5)
	*
	* @return complex
	*/
	public complex arcSin()
	{
		//w = -i*ln(iz + (1-z^2)^0.5)
		complex i = new complex(0, 1); //i
		complex one = new complex(1, 0); //1
		complex z = new complex(a, b); //to use methods

		complex temp1 = (one.subtract(z.powe(2))).powe(0.5); //(1-(z^2))^0.5
		complex temp2 = ((z.mult(i)).add(temp1)).comln(); //ln(iz+temp1)
		i.setImaginaryB(-1); //-i
		return(temp2.mult(i)); //-i * temp2
	}

	/*
	* INVERSE COSINE METHOD
	* 
	* uses principle that arccos(a + bi) = (pi/2, 0) - arcsin(a + bi)
	*
	* @return complex
	*/
	public complex arcCos()
	{
		complex ret = this.arcSin();
		ret.a = -ret.a + (Math.PI / 2);
		ret.b = -ret.b;
		return(ret);
	}

	/*COMPLEX QUADRATIC METHOD
	*
	* uses principle that x = [-b +/- sqrt(b^2 - 4ac)] / 2a
	* to find roots of complex quadratic
	*
	* @param complex a This represents a in ax^2 + bx + c
	* @param complex b2 This represents b in ax^2 + bx + c
	* @param complex c This represents c in ax^2 + bx + c
	* @param boolean posNeg If true add, if false subtract in +/- in [-b +/- sqrt(b^2 - 4ac)] / 2a
	* @return complex
	*/
	public static complex quad(complex a, complex b, complex c, boolean posNeg)
	{
		System.out.println(a.toString() + "x^2 + " + b.toString() + "x + " + c.toString()); //visually represent equation

		complex four = new complex(4); //4
		complex two = new complex(2); //2
		complex negOne = new complex(-1); //-1

		complex fourac = (c.mult(a)).mult(four);
		//System.out.println(fourac.toString());
		complex discriminant = ((b.powe(2)).subtract(fourac)).powe(0.5);
		//System.out.println(discriminant.toString());

		complex numerator = b.mult(negOne);
		if(posNeg) //if user wants to do + in +/-
		{
			numerator = numerator.add(discriminant);
		}
		else //if user wants to do - in +/-
		{
			numerator = numerator.subtract(discriminant);
		}

		return(numerator.div(a.mult(two)));
	}

}