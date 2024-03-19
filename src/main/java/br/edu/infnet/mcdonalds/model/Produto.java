package br.edu.infnet.mcdonalds.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        //include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Sobremesa.class, name = "sobremesa"),
        @JsonSubTypes.Type(value = Bebida.class, name = "bebida"),
        @JsonSubTypes.Type(value = Comida.class, name = "comida")
})


@AttributeOverrides({
        @AttributeOverride(name = "nome", column = @Column(name = "nome")),
        @AttributeOverride(name = "valor", column = @Column(name = "valor")),
        @AttributeOverride(name = "codigo", column = @Column(name = "codigo"))
})
public abstract class Produto {


    private String nome;


    private float valor;


    private Long codigo;

    public Produto(String nome, float valor, Long codigo) {
        this.nome = nome;
        this.codigo = codigo;
        setValor(valor);
    }
    public abstract void preparar();
    public abstract String toString();

}
