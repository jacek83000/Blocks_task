import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

interface Structure {
    // zwraca dowolny element o podanym kolorze
    Optional<Block> findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List<Block> findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(CompositeBlock compositeBlock) {
        this.blocks = compositeBlock.getBlocks();
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(b -> b.getColor().equals(color))
                .findAny();
    }

    // zwraca wszystkie elementy z danego materiału
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(b -> b.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }
}

interface Block {
    String getColor();
    String getMaterial();
}

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
