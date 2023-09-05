package tester;
import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getFactory()) {
			System.out.println("Hibernate up n running ....." + sf);
		}//sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
