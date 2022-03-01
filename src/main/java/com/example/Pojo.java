package com.example;

import com.google.common.collect.ImmutableList;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.TypeDef;
import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

import static io.micronaut.data.model.DataType.STRING_ARRAY;

@Builder // @Builder + @Singular is the one of use cases - having Immutable* at field allows Lombok to use Immutable*Builder instead or ArrayList
@ToString
@MappedEntity
public class Pojo {
    @Id
    @GeneratedValue
    private final Long id;
              // @Builder + @Singular is the one of use cases - having Immutable*
    @Singular // at field allows Lombok to use Immutable*Builder instead or ArrayList
    @TypeDef(type = STRING_ARRAY)
    private final ImmutableList<String> aliases;

    public List<String> getAliases() {
        return aliases;
    }

    public Long getId() {
        return id;
    }

    public Pojo(Long id, List<String> aliases) {
        this.id      = id;
        this.aliases = ImmutableList.copyOf(aliases);
    }
}
