public class App {
    public static void main(String[] args) throws Exception {
        
        Articolo mela = new Articolo("mela", 3, 0.69);
        Articolo banana = new Articolo("banana", 5, 0.49);
        Articolo pesca = new Articolo("pesca", 10, 0.99);
        Articolo sedia = new Articolo("sedia", 8, 12);
        Articolo tavolo = new Articolo("tavolo", 1, 54);
        Articolo armadio = new Articolo("armadio", 2, 110);
        
        Stand bruco = new Stand("bruco", null, new Articolo[]{mela, banana}, new Articolo[]{pesca});
        Stand ikea = new Stand("ikea", null, new Articolo[]{sedia, tavolo}, new Articolo[]{armadio});

        Negoziante palatella = new Negoziante("Enrico", "Palatella", "17/03/2004", 41, "disoccupato", bruco);
        Negoziante zlatan = new Negoziante("Zlatan", "Ibrahimovic", "3/10/1981", 41, "calciatore", ikea);

        Mercatino palladio = new Mercatino(new Negoziante[]{palatella, zlatan});

        System.out.println(palladio.toString());
    }
}

public class Mercatino {
    private Negoziante[] negozianti;

    public Mercatino(Negoziante[] negozianti) {
        this.negozianti = negozianti;
    }

    public String toString() {
        String res = "";
        for (Negoziante x : negozianti) {
            res += x.toString();
            res += x.getStand().toString();
        }
        return res;
    }
}

public class Negoziante {
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private int eta;
    private String professione;
    private Stand stand;

    public Negoziante(String nome, String cognome, String dataDiNascita, int eta, String professione, Stand stand) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.eta = eta; 
        this.professione = professione;
        this.stand = stand;

        stand.StandVenduto(this);
    }

    public String getNome() {
        return this.nome + ' ' + this.cognome;
    }

    public Stand getStand() {
        return this.stand;
    }

    public String toString() {
        return "- - - - -" + this.nome + "- - - - -\n" +
        this.cognome + "\n" +
        this.dataDiNascita + "\n" +
        this.eta + "\n" +
        this.professione + "\n" +
        this.getStand() + "\n===========================\n";
    }
}

public class Stand {
    private String nome;
    private Negoziante negoziante;
    private Articolo[] articoliInVendita;
    private Articolo[] articoliNelRetrobottega;

    public Stand(String nome, Negoziante negoziante, Articolo[] articoliInVendita, Articolo[] articoliNelRetrobottega) {
        this.nome = nome;
        this.negoziante = negoziante;
        this.articoliInVendita = articoliInVendita;
        this.articoliNelRetrobottega = articoliNelRetrobottega;
    }

    public void StandVenduto(Negoziante negoziante) {
        this.negoziante = negoziante;
    }

    public String getNegoziante() {
        return this.negoziante.getNome();
    }

    public String getNomeStand() {
        return this.nome;
    }

    public String toString() {
        return "- - - - -" + this.nome + "- - - - -\n" +
        this.negoziante.getNome() + "\n" +
        this.articoliInVendita.toString() + "\n" +
        this.articoliNelRetrobottega.toString() + "\n===========================\n";
    }
}


public class Articolo {
    private String nome;
    private double prezzo;
    private int quantita;

    public Articolo(String nome, int quantita, double prezzo) {
        this.nome = nome;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }
}