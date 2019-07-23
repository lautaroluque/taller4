export class Usuario {
    id: number;
    username: string;
    nombre: string;
    password: string;
    email: string;
    fechaDeNacimiento: object;
    notas: number[];
    favoritos: number[];
    imagenes: number[];
    audios: number[];
    categorias: number[];

    constructor(){}
}

export class LoginResponse{
    constructor(public token:string) {}
}