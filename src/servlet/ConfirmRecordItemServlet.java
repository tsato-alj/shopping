package servlet;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ConfirmRecordItemServlet
 */
@WebServlet("/confirmrecorditem")
public class ConfirmRecordItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmRecordItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemId = request.getParameter("itemId");
		System.out.println(itemId);
		String itemName = request.getParameter("itemName");
		System.out.println(itemName);
		System.out.println(request.getParameter("price"));
		int price = Integer.parseInt(request.getParameter("price"));
		HttpSession session = request.getSession(true);
		String producerId = (String)session.getAttribute("userId");
		String itemDescription = request.getParameter("item-description");

		Part image = request.getPart("image");
		final ZoneId HERE = ZoneId.of("Asia/Tokyo");
		DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("uuuu-MM-dd-HH-mm-ss-SSS");
		ZonedDateTime now = ZonedDateTime.now(HERE);
        String fileName = now.format(PATTERN);
        String extension = Optional.of(image.getSubmittedFileName())
                .filter(s -> s.length() > 0)
                .filter(s -> s.contains("."))
                .map(s -> s.substring(s.lastIndexOf(".")))
                .orElse("");
        image.write(fileName + extension);

		String category = request.getParameter("category");
	}
}