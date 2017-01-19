package metier;

public class Produit {
	
	private int id;
	private String nom;
	private Double prix;
	private Double poids;
	private int stock;
	
	public int getId() {
		return id;}
	public void setId(int id) {
		if (id<0)
			throw new InvalidIdException("id ne peut être négatif");
			this.id = id;}
	public String getNom() {
		return nom;	}
	public void setNom(String nom) {
		if (nom.length() < 3 || nom.length() > 50)
			throw new ProductNameException("format nom invalide");
		this.nom = nom;}
	public Double getPrix() {
		return prix;}
	public void setPrix(Double prix) {
		if(prix<0 || prix >1000)
			throw new ProductPriceProduct("prix hors intervalle");}
	public Double getPoids() {
		return poids;}
	public void setPoids(Double poids) {
		if (poids >= 0.01 || poids < 50.0)
		throw new ProductPoidsException("poids hors intervalle");
		this.poids = poids;}
	public int getStock() {
		return stock;}
	public void setStock(int stock) {
		if(stock<0)
		this.stock = stock;}
	public Produit(int id, String nom, Double prix, Double poids, int stock) {
		super();
		setId(id);// le constructeur appelle le set de id
		this.nom = nom;
		this.prix = prix;
		this.poids = poids;
		this.stock = stock;}
	
	
	public Produit() { this(0,"",0.0,0.0,0);}}
