package genericSerDeser.util;

public class Second {
	//Private Data Members
	private double DoubleValue;
	private double DoubleValue2;
	private long LongValue;
	private long LongValue2;
	private short ShortValue;
	private short ShortValue2;
	private String StringValue;
	
	
	/**
	 *Constructor used to initialize private data members 
	 */
	public Second(){
		Logger.writeMessage("In Second constructor", Logger.DebugLevel.CONSTRUCTOR);
		this.StringValue=null;
		this.ShortValue=0;
		this.LongValue=0;
		this.DoubleValue=0;
	}

	/**
	 * @param sIn
	 */
	public void setStringValue(String sIn) {
		StringValue = sIn;
	}


	/**
	 * @param shIn
	 */
	public void setShortValue(short shIn) {
		ShortValue = shIn;
	}

	/**
	 * @param lIn
	 */
	public void setLongValue(long lIn) {
		LongValue = lIn;
	}

	/**
	 * @param dIn
	 */
	public void setDoubleValue(double dIn) {
		DoubleValue = dIn;
	}
	
	/**
	 * @param shIn
	 */
	public void setShortValue2(short shIn) {
		ShortValue2 = shIn;
	}

	/**
	 * @param lIn
	 */
	public void setLongValue2(long lIn) {
		LongValue2 = lIn;
	}

	/**
	 * @param dIn
	 */
	public void setDoubleValue2(double dIn) {
		DoubleValue2 = dIn;
	}
	
	/**
	 * @return the doubleValue
	 */
	public double getDoubleValue() {
		return DoubleValue;
	}

	/**
	 * @return the doubleValue2
	 */
	public double getDoubleValue2() {
		return DoubleValue2;
	}

	/**
	 * @return the longValue
	 */
	public long getLongValue() {
		return LongValue;
	}

	/**
	 * @return the longValue2
	 */
	public long getLongValue2() {
		return LongValue2;
	}

	/**
	 * @return the shortValue
	 */
	public short getShortValue() {
		return ShortValue;
	}

	/**
	 * @return the shortValue2
	 */
	public short getShortValue2() {
		return ShortValue2;
	}

	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return StringValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Second other = (Second) obj;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		if(Short.toUnsignedInt(ShortValue) !=Short.toUnsignedInt(other.ShortValue)){
			return false;
		}
		if(Long.toUnsignedString(LongValue).hashCode() != Long.toUnsignedString(other.LongValue).hashCode()){
			return false;
		}
		if(Double.toString(DoubleValue).hashCode() != Double.toString(other.DoubleValue).hashCode()){
			return false;
		}
		if(Short.toUnsignedInt(ShortValue2) !=Short.toUnsignedInt(other.ShortValue2)){
			return false;
		}
		if(Long.toUnsignedString(LongValue2).hashCode() != Long.toUnsignedString(other.LongValue2).hashCode()){
			return false;
		}
		if(Double.toString(DoubleValue2).hashCode() != Double.toString(other.DoubleValue2).hashCode()){
			return false;
		}
		return true;
	}
	 /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * @return int
	 */
	@Override
	    public int hashCode() {
	        int result = 17;
	    	result = 31 * result + ((StringValue == null) ? 0 : StringValue.hashCode());
	        result = 31 * result + Short.toUnsignedInt(ShortValue);
	        result = 31 * result + Long.toUnsignedString(LongValue).hashCode();
	        result = 31 * result + Double.toString(DoubleValue).hashCode();
	        result = 31 * result + Short.toUnsignedInt(ShortValue2);
	        result = 31 * result + Long.toUnsignedString(LongValue2).hashCode();
	        result = 31 * result + Double.toString(DoubleValue2).hashCode();
	        return result;
	    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @return String
	 */
	@Override
	public String toString() {
		return "Second [DoubleValue=" + DoubleValue + ", DoubleValue2=" + DoubleValue2 + ", LongValue=" + LongValue
				+ ", LongValue2=" + LongValue2 + ", ShortValue=" + ShortValue + ", ShortValue2=" + ShortValue2
				+ ", StringValue=" + StringValue + "]";
	}
	
	
}

