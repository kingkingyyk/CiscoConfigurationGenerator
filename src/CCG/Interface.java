package CCG;

import java.util.HashMap;

public class Interface {
	public static HashMap<String,Interface> Map=new HashMap<>();
	String name, IPv4Add, IPv4Sub, OSPFArea, IPv6Add, IPv6Sub,OSPFV3Area,HSRPID,HSRPIP,HSRPPrio,
		  HSRPV3ID,HSRPV3IP,HSRPV3Prio, BGPAS, BGPV3AS;

	boolean OSPFEn,EIGRPEn,RIPEn,BGPEn,OSPFV3En,EIGRPv6En,RIPngEn,BGPv6En;
	
	
	public Interface (String n) {
		name=n;
		Map.put(name,this);
		CCG.ints.addLast(this);
	}
	
	public String toString() {
		return this.name;
	}
	
	public void destroy() {
		Map.remove(name);
		CCG.ints.remove(this);
	}
}
