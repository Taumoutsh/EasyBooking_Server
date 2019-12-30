package easybooking.server.authorizationGateway;

public class AuthorizationGatewayFactory {
	
	private static AuthorizationGatewayFactory agf = new AuthorizationGatewayFactory();
	
	public static AuthorizationGatewayFactory getAuthorizationGatewayFactory() {
		return agf;
	}
	
	public static IAuthorization createGateway(String website) {
		
		IAuthorization gateway = null;
		
		try{
			if(website.equals("Google")) {
				gateway = new Google();
			}
			else if(website.equals("Facebook")) {
				gateway = new Facebook();
			}
			else if(website.equals("Twitter")) {
				gateway = new Twitter();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return gateway;	
	}

}