import { Component } from '@angular/core';
import { UploadService } from 'src/app/services/upload.service';
import { Response } from 'src/app/models/response.model';
import { Environment } from 'src/app/environment/environment';
@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent {

  filename?: string;
  isFileUploaded: boolean = false;
  imagesSourceFolder: string = Environment.imagesFolder;

  constructor(private uploadService: UploadService) { }

  public onFileChanged(event: any): void {
    let file = event.target.files[0];
    let uploadForm = new FormData();
    uploadForm.append("file", file);
    this.uploadService.uploadImage(uploadForm)
    .subscribe(
      (image) => this.saveLastUploadedFile(image)
    );
  }

  private saveLastUploadedFile(response: Response):void {
    this.filename = response.data?.filename != undefined ? response.data?.filename : "Server error, please try again";
    this.isFileUploaded = true;
  }
}
