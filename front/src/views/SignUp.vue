<template>
  <div>
    <h1>SignUp</h1>
    <v-text-field
      label="아이디"
      v-model="memId"
      @keyup="idCheck"
    ></v-text-field>
    <span v-if="memIdCheck==1">사용할 수 없는 아이디입니다.</span>
    <v-text-field
      label="비밀번호"
      type="password"
      v-model="memPw1"
    ></v-text-field>
    <v-text-field
      label="비밀번호 확인"
      type="password"
      v-model="memPw2"
    ></v-text-field>
    <v-text-field
      label="닉네임"
      v-model="memName"
    ></v-text-field>
    <v-text-field
      label="기념일"
      v-model="memAnniversary"
    ></v-text-field>
    <v-menu
        ref="menu"
        v-model="menu"
        :close-on-content-click="false"
        transition="scale-transition"
        offset-y
        min-width="290px"
    >
    <template v-slot:activator="{ on, attrs }">
      <v-text-field
        v-model="memDate"
        label="Anniversary date"
        prepend-icon="mdi-calendar"
        readonly
        v-bind="attrs"
        v-on="on"
      ></v-text-field>
    </template>
    <v-date-picker
      ref="picker"
      v-model="memDate"
      :max="new Date().toISOString().substr(0, 10)"
      min="1950-01-01"
      @change="save"
    ></v-date-picker>
  </v-menu>
  </div>
</template>
<script>
  export default {
    data: () => ({
      memDate: null,
      menu: false,
      memId: null,
      memPw1: null,
      memPw2: null,
      memName: null,
      memIdCheck: 0,
      memPwCheck :true,
      memAnniversary:null
    }),
    watch: {
      menu (val) {
        val && setTimeout(() => (this.$refs.picker.activePicker = 'YEAR'))
      },
    },
    methods: {
      save (date) {
        this.$refs.menu.save(date)
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
        }
    }
  }
</script>