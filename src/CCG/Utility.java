package CCG;

public class Utility {

	public static String getSubnetMask (int subnet) {
		String s="";
		for (int i=0;i<subnet;i++) s+="1";
		for (int i=0;i<32;i++) s+="0";
		
		String returnS=Integer.parseInt(s.substring(0,8),2)+"."+Integer.parseInt(s.substring(8,16),2)+"."+Integer.parseInt(s.substring(16,24),2)+"."+Integer.parseInt(s.substring(24,32),2);
		return returnS;
	}
	
	public static String getWildcardMask (int subnet) {
		String subnetMask="";
		for (int i=0;i<subnet;i++) subnetMask+="1";
		for (int i=0;i<32;i++) subnetMask+="0";
		
		String wildcardMask="";
		for (int i=0;i<subnetMask.length();i++) {
			if (subnetMask.charAt(i)=='0') {
				wildcardMask+="1";
			} else if (subnetMask.charAt(i)=='1') {
				wildcardMask+="0";
			} else {
				wildcardMask+=subnetMask.charAt(i);
			}
		}
		
		String returnS=Integer.parseInt(wildcardMask.substring(0,8),2)+"."+Integer.parseInt(wildcardMask.substring(8,16),2)+"."+Integer.parseInt(wildcardMask.substring(16,24),2)+"."+Integer.parseInt(wildcardMask.substring(24,32),2);
		return returnS;
	}
	
	public static boolean [] getSubnetBits (int subnet) {
		boolean [] bits=new boolean [32];
		for (int i=0;i<subnet;i++) bits[i]=true;
		return bits;
	}
	
	public static String getSubnetAddress (String hostAdd, int subnet) {
		String [] split=hostAdd.split("\\.");
		boolean [] bits=new boolean [32];
		for (int i=0;i<4;i++) {
			String bin=Integer.toBinaryString(Integer.parseInt(split[i]));
			while (bin.length()<8) bin="0"+bin;
			for (int i2=0;i2<8;i2++) {
				bits[i*8+i2]=(bin.charAt(i2)=='1');
			}
		}
		
		
		boolean [] subnetBits=getSubnetBits(subnet);
		boolean [] result=new boolean [32];
		for (int i=0;i<32;i++) {
			result[i]=bits[i] && subnetBits[i];
		}
		
		String s="";
		for (int i=0;i<32;i++) {
			if (result[i]) s+="1"; else s+="0";
		}

		String returnS=Integer.parseInt(s.substring(0,8),2)+"."+Integer.parseInt(s.substring(8,16),2)+"."+Integer.parseInt(s.substring(16,24),2)+"."+Integer.parseInt(s.substring(24,32),2);
		return returnS;
	}
	
}
