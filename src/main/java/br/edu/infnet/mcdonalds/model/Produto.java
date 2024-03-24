
package br.edu.infnet.mcdonalds.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Sobremesa.class, name = "sobremesa"),
        @JsonSubTypes.Type(value = Bebida.class, name = "bebida"),
        @JsonSubTypes.Type(value = Comida.class, name = "comida")
})

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Produto {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private float valor;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID codigo;

    public Produto(String nome, float valor, UUID codigo) {
        this.nome = nome;
        this.codigo = codigo;
        setValor(valor);
    }
    public abstract void preparar();
    public abstract String toString();

}
