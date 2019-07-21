export class Usuario {
    username: string;
    nombre: string;
    password: string;

    constructor(public status:string){}
}

export class LoginResponse{
    constructor(
      public token:string,
       ) {}
  }