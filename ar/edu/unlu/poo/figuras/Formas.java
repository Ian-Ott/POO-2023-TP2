package ar.edu.unlu.poo.figuras;

import java.util.ArrayList;

public class Formas {
    private ArrayList<Figura2D> figuras2d = new ArrayList<>();
    private ArrayList<Figura3D> figuras3d = new ArrayList<>();

    public void nuevoCirculo(Double radio) {
        Circulo nuevo_circulo = new Circulo();
        nuevo_circulo.setRadio(radio);
        figuras2d.add(nuevo_circulo);
    }

    public void nuevoCuadrado(Double lado1, Double lado2) {
        Cuadrado nuevo_cuadrado = new Cuadrado();
        nuevo_cuadrado.setLado1(lado1);
        nuevo_cuadrado.setLado2(lado2);
        figuras2d.add(nuevo_cuadrado);
    }

    public void nuevoCubo(Double arista){
        Cubo nuevo_cubo = new Cubo();
        nuevo_cubo.setArista(arista);
        figuras3d.add(nuevo_cubo);

    }

    public void nuevaEsfera(Double radio){
        Esfera nueva_esfera = new Esfera();
        nueva_esfera.setRadio(radio);
        figuras3d.add(nueva_esfera);
    }

    public void nuevoParalelepipedo(Double arista1, Double arista2, Double arista3){
        Paralelepipedo nuevo_p = new Paralelepipedo();
        nuevo_p.setArista1(arista1);
        nuevo_p.setArista2(arista2);
        nuevo_p.setArista3(arista3);
        figuras3d.add(nuevo_p);
    }

    public void nuevoRectangulo(Double base, Double altura){
        Rectangulo nuevo_rectangulo = new Rectangulo();
        nuevo_rectangulo.setAltura(altura);
        nuevo_rectangulo.setBase(base);
        figuras2d.add(nuevo_rectangulo);
    }

    public void nuevoTetraedro(Double arista){
        Tetraedro nuevo_tetraedro = new Tetraedro();
        nuevo_tetraedro.setArista(arista);
        figuras3d.add(nuevo_tetraedro);
    }

    public void nuevoTriangulo(Double base, Double altura){
        Triangulo nuevo_triangulo = new Triangulo();
        nuevo_triangulo.setBase(base);
        nuevo_triangulo.setAltura(altura);
        figuras2d.add(nuevo_triangulo);
    }

    public void mostrarFiguras2D(){
        for (int i = 0; i < figuras2d.size(); i++){
            figuras2d.get(i).calcularArea();
            System.out.println((i+1) + "-Area: " + figuras2d.get(i).getArea());
        }
    }

    public void mostrarFiguras3D(){
        for (int i = 0; i < figuras3d.size(); i++){
            figuras3d.get(i).calcularArea();
            System.out.println((i+1) + "-Area: " + figuras3d.get(i).getArea());
            figuras3d.get(i).calcularVolumen();
            System.out.println((i+1) + "-Volumen: " + figuras3d.get(i).getVolumen());
        }
    }
}
