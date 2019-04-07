package com.kiakora;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class RegionService {

    List<Region> allRegions(){
        List<Region> regions = new ArrayList<>();
        regions.add(new Region("andalucia", "Andalucía"));
        regions.add(new Region("aragon", "Aragón"));
        regions.add(new Region("asturias", "Asturias"));
        regions.add(new Region("cantabria", "Cantabria"));
        regions.add(new Region("castillaLaMancha", "Castilla la Mancha"));
        regions.add(new Region("castillaLeon", "Castilla León"));
        regions.add(new Region("catalunya", "Cataluña"));
        regions.add(new Region("extremadura", "Extremadura"));
        regions.add(new Region("galicia", "Galicia"));
        regions.add(new Region("baleares", "Islas Baleares"));
        regions.add(new Region("canarias", "Islas Canarias"));
        regions.add(new Region("madrid", "Madrid"));
        regions.add(new Region("murcia", "Murcia"));
        regions.add(new Region("rioja", "La Rioja"));
        regions.add(new Region("valencia", "Comunidad Valenciana"));
        regions.add(new Region("ceuta", "Ceuta"));
        regions.add(new Region("melilla", "Melilla"));
        return regions;
    }

}
