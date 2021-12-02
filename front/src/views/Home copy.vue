<template>
  <div>
    {{info}}
  </div>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      diaryNum: '2',
      info: null
    }
  },
  mounted () {
    axios
      .get('http://localhost:7000/magic/getDiary/' + this.diaryNum)
      .then(response => {
        console.log('a')
        this.info = response.data
      })
      .catch(e => {
        console.log(e)
        this.errored = true
      })
      .finally(() => this.loading = false)
  }
}
</script>
