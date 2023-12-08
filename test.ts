```
import { Component, OnInit } from '@angular/core';
import {FormTemplate} from "../models/form-template";
import {FormBuilder, FormControl, FormGroup, ValidatorFn, Validators} from "@angular/forms";
import {TemplateFormServiceService} from "../services/template-form-service.service";

@Component({
  selector: 'app-template-form',
  templateUrl: './template-form.component.html',
  styleUrls: ['./template-form.component.scss']
})
export class TemplateFormComponent implements OnInit {
  genFormGroup!:FormGroup
  constructor(private fb:FormBuilder , private tempService :TemplateFormServiceService ) { }
  template1 : FormTemplate[] =[

    {
      'templateNm': 'first-template',
      'inputTp': 'text',
      'label': 'custom label',
      'placeholder': 'custom ph',
      'formCtlName': 'dbField1',

      'validators': [
        {
          'valType':'required',
          'valSubType':null,
          'description':'required field.',
          'valValue':'required'
        },
        {
          'valType':'minLenght',
          'valSubType':null,
          'description':'min lenght should be ',
          'valValue':10
        },
        {
          'valType':'pattern',
          'valSubType':'email',
          'description':'email not valid ',
          'valValue':'^\\S+@\\S+$'
        }
      ]
    },
    {
      'templateNm': 'first-template',
      'inputTp': 'date',
      'label': 'custom label date',
      'placeholder': 'custom number',
      'formCtlName': 'dbField5',

      'validators': [
        {
          'valType':'required',
          'valSubType':null,
          'description':'required field.',
          'valValue':'required'
        }
      ]
    },
    {
      'templateNm': 'first-template',
      'inputTp': 'number',
      'label': 'custom label number',
      'placeholder': 'custom number',
      'formCtlName': 'dbField4',

      'validators': [
        {
          'valType':'required',
          'valSubType':null,
          'description':'required field.',
          'valValue':'required'
        },
        {
          'valType':'min',
          'valSubType':null,
          'description':'min value should be ',
          'valValue':10
        },
        {
          'valType':'max',
          'valSubType':null,
          'description':'max value should be ',
          'valValue':20
        },
      ]
    },
    {
      'templateNm': 'first-template',
      'inputTp': 'radio',
      'label': 'custom label radio',
      'placeholder': 'custom radio',
      'formCtlName': 'dbField8',

      'validators': [
        {
          'valType':'required',
          'valSubType':null,
          'description':'required field.',
          'valValue':'required'
        }
      ]
    },



  ];
  template2 : FormTemplate[] =[


    {
      'templateNm': 'second-template',
      'inputTp': 'radio',
      'label': 'custom radio from second T',
      'placeholder': 'custom radio',
      'formCtlName': 'dbField8',

      'validators': [
        {
          'valType':'required',
          'valSubType':null,
          'description':'required field.',
          'valValue':'required'
        }
      ]
    },


  ];
  template3 : FormTemplate[] =[

    {
      'templateNm': 'third-template',
      'inputTp': 'number',
      'label': 'custom  number from third T',
      'placeholder': 'custom number',
      'formCtlName': 'dbField4',

      'validators': [
        {
          'valType':'required',
          'valSubType':null,
          'description':'required field.',
          'valValue':'required'
        },
        {
          'valType':'min',
          'valSubType':null,
          'description':'min value should be ',
          'valValue':10
        },
        {
          'valType':'max',
          'valSubType':null,
          'description':'max value should be ',
          'valValue':20
        },
      ]
    },

  ];
  isSelected !:boolean
  formFields !: FormTemplate[]

  templates:string[]=[
    'first-template','template-2','third-template','driss'
  ]
  ngOnInit(): void {
    this.genFormGroup =this.fb.group(
      {}
    )
  }
  handelShowTemplate(templateName:string) {

    this.tempService.getTemplateForm(templateName).subscribe({
      next:data=>{
        console.log("template from backend ")
        this.formFields=data;

        this.formFields.forEach(f=>{
          let validatorList :  ValidatorFn[] = []
          f.validators.forEach(v => {
            if(v.valType === 'required') validatorList.push(Validators.required)
            if(v.valType === 'minLenght') validatorList.push(Validators.minLength(v.valValue))
            if (v.valType === 'pattern') validatorList.push(Validators.pattern(v.valValue))
            if (v.valType === 'min') validatorList.push(Validators.min(v.valValue))
            if (v.valType === 'max') validatorList.push(Validators.max(v.valValue))
          })
          this.genFormGroup.addControl(f.formCtlName,new FormControl('',validatorList))

        })
      }
    })


  }

  handelFormData() {

    console.log("****************form value*****************")
    console.log(this.genFormGroup.value)
     this.tempService.saveFormDataTarget(this.genFormGroup.value).subscribe({
       next:data=>{
         console.log(data)
       }
     })
    console.log("*******************************************")

  }
}


```
