/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author deepakga
 */
public class RdfParser extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String str = request.getParameter("search");

        if (str == null) {

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        } else {  //Search parameter has some value input by user

            Model model = ModelFactory.createDefaultModel();
            // model.read("http://dbpedia.org/data/Pieris_(plant)");
            System.out.println("Got the Model");

            //Resource vcard = model.getResource("http://dbpedia.org/resource/Busan");
            //System.out.println("Got the Resource = " + vcard);

            // list the statements in the Model

// use the FileManager to find the input file
            // InputStream in = FileManager.get().open("Mangifera_indica.rdf");
            // if (in == null) {
            //   throw new IllegalArgumentException(
            //         "File: " + "Busan.rdf" + " not found");
            //}

// read the RDF/XML file
            //model.read(in, null);

            //Resource r = model.getResource("http://dbpedia.org/resource/Mangifera_indica");

            String n = "http://dbpedia.org/resource/Mangifera_indica";
            model.read(n);
            String NS = "http://www.w3.org/2000/01/rdf-schema#";
            String onto = "http://dbpedia.org/ontology/";
            Resource title2 = model.getResource(n);
            System.out.println("Resource = " + title2);

            Property cmnt = model.getProperty(NS + "comment");
            System.out.println("Property = " + cmnt);
            String commnts = null;



            Property name = model.getProperty("http://dbpedia.org/property/name");
            Property kingdom = model.getProperty(onto + "kingdom");
            Property species = model.getProperty("http://dbpedia.org/property/species");
            Property genus = model.getProperty("http://dbpedia.org/ontology/genus");
            Property familia = model.getProperty("http://dbpedia.org/property/familia");
            Property divisio = model.getProperty("http://dbpedia.org/property/divisio");
            Property picture = model.getProperty("http://xmlns.com/foaf/0.1/depiction");


//System.out.println( "Comment is = " + title2.getProperty( cmnt ).getObject());
            System.out.println("Name is = " + title2.getProperty(name).getObject());
            System.out.println("Kingdom is = " + title2.getProperty(kingdom).getObject());
            System.out.println("Species is = " + title2.getProperty(species).getObject());
            System.out.println("Genus is = " + title2.getProperty(genus).getObject());
            System.out.println("Familia is = " + title2.getProperty(familia).getObject());
            System.out.println("Divisio is = " + title2.getProperty(divisio).getObject());
            System.out.println("Image URL is = " + title2.getProperty(picture).getObject());

            NodeIterator ni = model.listObjectsOfProperty(title2, cmnt);
            while (ni.hasNext()) {

                String s = ni.next().toString();

                if (s.endsWith("@en")) {

                    int ends = s.indexOf("@");
                    commnts = s.substring(0, ends);
                    System.out.println("Comments = " + s.substring(0, ends));

                }


            }
            
            
            int en = n.lastIndexOf("/");
            String search = n.substring(en + 1, n.length());

            String searchname = title2.getProperty(name).getObject().toString();
            System.out.println(searchname);
            int end1 = searchname.indexOf("@en");
            searchname = searchname.substring(0, end1);

            String searchspecies = title2.getProperty(species).getObject().toString();
            int end2 = searchspecies.indexOf("@en");
            searchspecies = searchspecies.substring(0, end2);

            String searchdivisio = title2.getProperty(divisio).getObject().toString();
            int end3 = searchdivisio.indexOf("@en");
            searchdivisio = searchdivisio.substring(0, end3);

            String searchgenus = title2.getProperty(genus).getObject().toString();
            int end4 = searchgenus.lastIndexOf("/");
            searchgenus = searchgenus.substring(end4 + 1, searchgenus.length());

            String searchkingdom = title2.getProperty(kingdom).getObject().toString();
            int end5 = searchkingdom.lastIndexOf("/");
            searchkingdom = searchkingdom.substring(end5 + 1, searchkingdom.length());

            String searchfamilia = title2.getProperty(familia).getObject().toString();
            int end6 = searchfamilia.lastIndexOf("/");
            searchfamilia = searchfamilia.substring(end6 + 1, searchfamilia.length());


            request.setAttribute("search", search);
            request.setAttribute("str", searchname);
            request.setAttribute("name", searchname);
            request.setAttribute("kingdom", searchkingdom);
            request.setAttribute("species", searchspecies);
            request.setAttribute("genus", searchgenus);
            request.setAttribute("familia", searchfamilia);
            request.setAttribute("divisio", searchdivisio);
            request.setAttribute("image", title2.getProperty(picture).getObject().toString());
            request.setAttribute("commnts", commnts);

           // String KingdomURL = getWikipediaURL(title2.getProperty(kingdom).getObject().toString());
            request.setAttribute("kingdomURL", "http://en.wikipedia.org/wiki/Plant");
            
            String genusURL = getWikipediaURL(title2.getProperty(genus).getObject().toString());
            request.setAttribute("genusURL", genusURL);
            
             String familiaURL = getWikipediaURL(title2.getProperty(familia).getObject().toString());
            request.setAttribute("familiaURL", familiaURL);
            
            
            

            //requesting instance of RequestDispatcher class for result.jsp
            RequestDispatcher view = request.getRequestDispatcher("result.jsp");

            //forwarding request and response instance to result.jsp for displaying.
            view.forward(request, response);

        }


    }

    String getWikipediaURL(String s) {

        Model model_w = ModelFactory.createDefaultModel();
        
        model_w.read(s);
        Resource title = model_w.getResource(s);
        Property p = model_w.getProperty("http://xmlns.com/foaf/0.1/isPrimaryTopicOf");
        System.out.println();
        String url1 = title.getProperty(p).getObject().toString();

        return url1;
    }
}
