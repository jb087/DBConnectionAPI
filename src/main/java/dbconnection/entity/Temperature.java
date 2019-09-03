package dbconnection.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperature")
@Getter
@Setter
public class Temperature implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "sensor_id")
    private int sensorId;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @Column(name = "temperature")
    private float temperature;
}
