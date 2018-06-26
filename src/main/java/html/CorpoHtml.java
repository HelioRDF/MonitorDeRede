package html;

public class CorpoHtml {
	

	public static String bodyHTML(String resultado) {
		//embed the image and get the content id

		StringBuffer msgs = new StringBuffer();
		msgs.append("<!DOCTYPE html> ");
		msgs.append("<html>");
			
			msgs.append("<head>");
				msgs.append("<meta charset=\"utf-8\">");
			
				
			msgs.append("</head>");
					
			msgs.append("<body style=\"background:#d4d4d4; \">");
			
				msgs.append("<div> &ensp;");
							
					msgs.append(resultado);
						
			
				
			msgs.append("</div>  "
					+ "</body>");
			
		msgs.append("</html>");

		return msgs.toString();

	}

}


