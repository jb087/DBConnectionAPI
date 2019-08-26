package dbconnection.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datetime;

    @Column(name = "temperature")
    private float temperature;
}
