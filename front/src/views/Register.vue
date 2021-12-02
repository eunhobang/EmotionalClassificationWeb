<template>
  <div class="Register">


        <v-text-field
            type="text"
            placeholder="enter memId"
            v-model="memId"
            @keyup="idCheck"
            required
        />
        <span v-if="memIdCheck=='1'">사용중인 아이디입니다.</span>
        
        <v-text-field
            type="text"
            placeholder="enter memName"
            class="mb-2"
            v-model="memName"
            required
        />

        <v-text-field
            type="password"
            placeholder="enter password"
            class="mb-2"
            v-model="memPw1"
            required
        />

        <v-text-field
            type="password"
            placeholder="check password"
            class="mb-2"
            v-model="memPw2"
            required
        />
        <span v-if="!memPwCheck">비밀번호가 일치하지 않습니다.</span>

        <v-text-field
            type="text"
            placeholder="enter memAnniversary"
            class="mb-2"
            v-model="memAnniversary"
            required
        />

        <v-date-picker v-model="memDate"></v-date-picker>


  </div>
</template>

<script>
export default {
    name : "register",
    data() {
        return {
            loading: true,
            errored: false,
            memId: "",
            memPw1: "",
            memPw2: "",
            memName: "",
            memIdCheck: '0',
            memPwCheck: true,
            memAnniversary: ""
            // memIdRules: [
            //     v => !!v || '아이디를 입력해주세요.',
            //     v => /^[a-zA-Z0-9]{8,24}$/.test(v) || '아이디가 유효하지 않습니다.'
            // ],
            // passwordRules: [
            //     v => !!v || '패스워드를 입력해주세요.',
            //     v => /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,16}$/.test(v) || 
            //         '패스워드가 유효하지 않습니다.'
            // ],
            // checkPasswordRules: [
            //     v => !!v || '패스워드를 다시 한번 입력해주세요.',
            //     v => this.memPw1 === this.memPw2 || '패스워드가 일치하지 않습니다.'
            // ]
        }
    },
    methods: {
        register() {
            if (this.memId == "") {
                alert("아이디를 입력하세요");
                return;
            }
            if (this.memPw == "") {
                alert("비밀번호를 입력하세요");
                return;
            }
            if (this.memIdCheck>0) {
                return alert("중복된 아이디를 입력하셨습니다.")
            } else if (this.memPwCheck == false) {
                return alert("비밀번호를 다시 확인해주세요.")
            }
            if (this.memName == "") {
                alert("사용하실 닉네임을 입력해주세요");
                return;
            }
            if (this.memAnniversary == "") {
                alert("기념일 종류 입력하세요");
                return;
            }
            if (this.memDate == "") {
                alert("기념일을 선택하세요");
                return;
            }
            axios
                .post("http://localhost:7000/magic/register", {
                    memId: this.memId,
                    memPw: this.memPw1,
                    memName: this.memName,
                    memAnniversary: this.memAnniversary,
                    memDate: this.memDate
                })
                .then(response => {
                    alert(`${this.memName}님, 가입을 축하드립니다.`);
                    location.href = "index.html"
                })
                .catch(error => {
                    console.log(error);
                    this.errored = true
                })
                .finally(() => this.loading = false)
        },
        idCheck() {
            axios
                .get("http://localhost:7000/magic/idCheck/" + this.memId)
                .then(response => (this.memIdCheck = response.data))
                .catch(error => {
                    console.log(error);
                    this.errored = true
                })
                .finally(() => this.empEmpty = false)
        },
        pwCheck() {
            if (this.memPw1 != this.memPw2) {
                this.memPwCheck = false;
            } else {
                this.memPwCheck = true;
            }
        }

    }


}
