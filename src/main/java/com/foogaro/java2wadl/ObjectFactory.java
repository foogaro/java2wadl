package com.foogaro.java2wadl;

import com.foogaro.java2wadl.model.*;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * @author foogaro
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.foogaro.java2wadl.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link com.foogaro.java2wadl.model.Resources }
     * 
     */
    public Resources createResources() {
        return new Resources();
    }

    /**
     * Create an instance of {@link com.foogaro.java2wadl.model.Doc }
     * 
     */
    public Doc createDoc() {
        return new Doc();
    }

    /**
     * Create an instance of {@link com.foogaro.java2wadl.model.Resource }
     * 
     */
    public Resource createResource() {
        return new Resource();
    }

    /**
     * Create an instance of {@link com.foogaro.java2wadl.model.Param }
     * 
     */
    public Param createParam() {
        return new Param();
    }

    /**
     * Create an instance of {@link com.foogaro.java2wadl.model.Option }
     * 
     */
    public Option createOption() {
        return new Option();
    }

    /**
     * Create an instance of {@link Link }
     * 
     */
    public Link createLink() {
        return new Link();
    }

    /**
     * Create an instance of {@link Method }
     * 
     */
    public Method createMethod() {
        return new Method();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link Representation }
     * 
     */
    public Representation createRepresentation() {
        return new Representation();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link Application }
     * 
     */
    public Application createApplication() {
        return new Application();
    }

    /**
     * Create an instance of {@link Grammars }
     * 
     */
    public Grammars createGrammars() {
        return new Grammars();
    }

    /**
     * Create an instance of {@link Include }
     * 
     */
    public Include createInclude() {
        return new Include();
    }

    /**
     * Create an instance of {@link ResourceType }
     * 
     */
    public ResourceType createResourceType() {
        return new ResourceType();
    }

}
