package model;

import java.util.ArrayList;
import java.util.List;

import exception.ExcecaoPersonalizada;

public class Veiculo {
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int anoModelo;
    private String motorizacao;
    private double capacidadeTanque;
    private String combustiveis;
    private String cor;
    private String placa;
    private String renavam;
    private List<Despesa> despesas;
    private List<Abastecimento> abastecimentos;
    private int quilometragemAtual; // Adiciona o atributo para a quilometragem

    public Veiculo(String marca, String modelo, int anoFabricacao, int anoModelo, String motorizacao, double capacidadeTanque, String combustiveis, String cor, String placa, String renavam, int quilometragemAtual) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.motorizacao = motorizacao;
        this.capacidadeTanque = capacidadeTanque;
        this.combustiveis = combustiveis;
        this.cor = cor;
        this.placa = placa;
        this.renavam = renavam;
        this.despesas = new ArrayList<>();
        this.abastecimentos = new ArrayList<>();
        this.quilometragemAtual = quilometragemAtual; // Inicializa a quilometragem
    }

    public String getPlaca() {
        return placa;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void adicionarDespesa(Despesa despesa) {
        despesas.add(despesa);
    }

    public void adicionarAbastecimento(Abastecimento abastecimento) throws ExcecaoPersonalizada {
        // Verifica se a quilometragem é válida antes de adicionar o abastecimento
        if (abastecimento.getQuilometragemAtual() < quilometragemAtual) {
            throw new ExcecaoPersonalizada("A quilometragem atual não pode ser menor que a quilometragem anterior.");
        }

        abastecimentos.add(abastecimento);
        Despesa despesaAbastecimento = new Despesa("abastecimento", abastecimento.getValor(),
                "Abastecimento: " + abastecimento.getQuantidadeCombustivel() + " litros",
                abastecimento.getData(), "abastecimento");
        despesas.add(despesaAbastecimento);
        // Atualiza a quilometragem após o abastecimento
        quilometragemAtual = abastecimento.getQuilometragemAtual();
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public List<Despesa> getDespesasPorCategoria(String categoria) {
        List<Despesa> despesasFiltradas = new ArrayList<>();
        for (Despesa despesa : despesas) {
            if (despesa.getTipo().equalsIgnoreCase(categoria)) {
                despesasFiltradas.add(despesa);
            }
        }
        return despesasFiltradas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public String getCombustiveis() {
        return combustiveis;
    }

    public void setCombustiveis(String combustiveis) {
        this.combustiveis = combustiveis;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public void setAbastecimentos(List<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }

    public int getQuilometragemAtual() {
        return quilometragemAtual;
    }

    public void setQuilometragemAtual(int quilometragemAtual) {
        this.quilometragemAtual = quilometragemAtual;
    }
}
