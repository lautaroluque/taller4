export class Nota {
  id: number;
  nombre: string;
  contenido: string;

  constructor(nombre: string, contenido: string) {
    this.nombre = nombre;
    this.contenido = contenido;
  }
}
