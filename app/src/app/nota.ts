export class Nota {
  id: number;
  nombre: string;
  contenido: string;
  dueño: string;

  constructor(nombre: string, contenido: string) {
    this.nombre = nombre;
    this.contenido = contenido;
  }
}
