<template>
  <div class="app-container">

	  <span class="info">请输入载体图片</span>
	  <div class="uploadFile">
          <div v-show="uploadImg1!=null" class="addPic">
            <img class="img1" :src="uploadImg1">
          </div>
        <input type="file"
               id="file1"
               accept="image/*"
               @change="getPicture1($event)">
        <button class="sub1" @click="callFile1"
                v-show="showInputImg1">+</button>
      </div>

	  <span class="info">请输入水印图片</span>
	  <div class="uploadFile">
          <div v-show="uploadImg2!=null" class="addPic">
            <img class="img2" :src="uploadImg2">
          </div>
        <input type="file"
               id="file2"
               accept="image/*"
               @change="getPicture2($event)">
        <button class="sub2" @click="callFile2"
                v-show="showInputImg2">+</button>
      </div>

  </div>
</template>

<script>
import Axios from 'axios';
export default {
  data(){
			return {
				uploadImg1:null,
				uploadImg2:null,
			}
		},
  		computed: {
		    showInputImg1 () {
		      return this.uploadImg1 == null;
			},
			showInputImg2 () {
		      return this.uploadImg2 == null;
		    }
  		},
  		methods: {
  			getPicture1 (e) {
		      //预览图片
		      let src = window.URL.createObjectURL(e.target.files[0]);
		      this.uploadImg1 = src;
		
		      console.log(e.target.files[0])
          
          let Formdata = new FormData()
          Formdata.append("image", e.target.files[0])
		        //e.target.result  就是从本地读取的图片的base64格式,将它上传给服务器即可
		        //使用axios的post方法上传即可
          Axios
          .post(
            "http://localhost:8080/Upload",
            Formdata
          )
			},
			getPicture2 (e) {
		      //预览图片
		      let src = window.URL.createObjectURL(e.target.files[0]);
		      this.uploadImg2 = src;
		
		      console.log(e.target.files[0])
          
          let Formdata = new FormData()
          Formdata.append("image", e.target.files[0])
		        //e.target.result  就是从本地读取的图片的base64格式,将它上传给服务器即可
		        //使用axios的post方法上传即可
          Axios
          .post(
            "http://localhost:8080/Upload",
            Formdata
          )
		    },
		    callFile1 () {
		      //点击添加图片按钮，触发type:"file"的input标签
		      let fileDom = document.querySelector("#file1")
		      fileDom.click()
			},
			callFile2 () {
		      //点击添加图片按钮，触发type:"file"的input标签
		      let fileDom = document.querySelector("#file2")
		      fileDom.click()
		    }
  		}
}
</script>

<style scoped>
.info{
	margin-left: 575px;
}
input {
		  /* 隐藏默认的"打开文件"样式 */
		  display: none;
		}
		.uploadFile {
		  margin: 0 auto;
		  display: flex;
		  height: 320px;
		  line-height: 320px;
		  padding: 10px 0;
		  border-bottom: 1px solid rgb(235, 235, 235);
		  overflow: hidden;
		}
		.uploadFile .addPic .img1 {
		margin-left: 500px;
		  height: 100%;
		}
		.uploadFile .addPic .img2 {
		margin-left: 600px;
		  height: 50%;
		}
		.uploadFile .sub1 {
			margin: 0 auto;
		  height: 300px;
		  width: 300px;
		  font-size: 50px;
		  border: 1px dashed rgb(182, 182, 182);
		  color: rgb(182, 182, 182);
		  background-color: rgb(243, 243, 243);
		}
		.uploadFile .sub2 {
		margin: 0 auto;
		  height: 200px;
		  width: 200px;
		  font-size: 50px;
		  border: 1px dashed rgb(182, 182, 182);
		  color: rgb(182, 182, 182);
		  background-color: rgb(243, 243, 243);
		}
</style>

