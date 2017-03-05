package client;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlImporter;
import com.eviware.soapui.model.iface.Operation;

public class WsBom {
	public static void main(String[] args) throws Exception {
		String wsdlUrl = "http://ws.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";

		WsdlProject project = new WsdlProject();
		WsdlInterface[] wsdls = WsdlImporter.importWsdl(project, wsdlUrl);

		for (Operation operation : wsdls[0].getOperationList()) {
			WsdlOperation op = (WsdlOperation) operation;
			System.out.println(op.createRequest(true));
			System.out.println(op.createResponse(true));
		}

	}
}
