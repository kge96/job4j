package ru.job4j.carcatalog;

import ru.job4j.carcatalog.modules.Body;
import ru.job4j.carcatalog.modules.Engine;
import ru.job4j.carcatalog.modules.Producer;
import ru.job4j.carcatalog.modules.Transmission;

/**
 * Class for creating car.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.11.2017.
 */
public class Car {
    /**
     * Car id.
     */
    private int id;
    /**
     * Car body.
     */
    private Body body;
    /**
     * Car producer.
     */
    private Producer producer;
    /**
     * Car engine.
     */
    private Engine engine;
    /**
     * Car transmission.
     */
    private Transmission transmission;

    /**
     * Default constructor.
     */
    public Car() {

    }

    /**
     * Constructor.
     * @param body - body.
     * @param producer - producer.
     * @param engine - engine.
     * @param transmission - transmission.
     */
    public Car(Body body, Producer producer, Engine engine, Transmission transmission) {
        this.body = body;
        this.producer = producer;
        this.engine = engine;
        this.transmission = transmission;
    }

    /**
     * Constructor.
     * @return int.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for body.
     * @return Body.
     */
    public Body getBody() {
        return body;
    }

    /**
     * Setter for body.
     * @param body - body.
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * Getter for producer.
     * @return Producer.
     */
    public Producer getProducer() {
        return producer;
    }

    /**
     * Setter for producer.
     * @param producer - Producer.
     */
    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    /**
     * Getter for engine.
     * @return Engine.
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Setter for Engine.
     * @param engine - engine.
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * Getter for transmission.
     * @return Transmission.
     */
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     * Setter for transmission.
     * @param transmission transmission.
     */
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{"
                + "id=" + id
                + ", body=" + body.getType()
                + ", producer=" + producer.getMark()
                + ", engine=" + engine.getVolume()
                + ", transmission=" + transmission.getType()
                + '}';
    }
}
