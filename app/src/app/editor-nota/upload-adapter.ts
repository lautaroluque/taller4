import { ImageService } from "../image.service";
import { HttpParams, HttpClient } from "@angular/common/http";

export class MiUploadAdapter {
  loader: any;
  imageService: ImageService;
  username: string;

  constructor(loader: any, imageService: ImageService, username: string) {
    this.loader = loader;
    this.imageService = imageService;
    this.username = username;
    console.log('Upload Adapter Constructor', this.loader, this.imageService, this.username);
  }

  upload() {
    let upload = new Promise((resolve, reject) => {
      this.loader['file'].then(
        (data) => {
          this.imageService.upload(data, this.username)
            .subscribe(
              (result) => {
                resolve({ default: result.fileDownloadUri })
              },
              (error) => {
                reject(data.msg);
              }
            );
        }
      );
    });
    return upload;
  }

  abort() {
    console.log("abort")
  }
}