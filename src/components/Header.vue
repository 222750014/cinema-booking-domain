<template>
  <header class="header">
    <div class="header-container">
      <div class="logo">
        <h1>Tickets</h1>
        <span>Booking online</span>
      </div>
      
      <div class="search-section">
        <input 
          type="text" 
          class="search-input" 
          placeholder="Search movies, theaters..."
          v-model="searchQuery"
        >
        <button class="search-btn">🔍</button>
      </div>
      
      <div class="user-section">
        <span>Hi Guest, Sign in| Register</span>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: 'Header',
  data() {
    return {
      searchQuery: ''
    }
  }
}
</script>

<style scoped>
.header {
  background: linear-gradient(135deg, #ff6b35, #f7931e);
  padding: 10px 0;
  color: white;
}

.header-container {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
}

.logo h1 {
  margin: 0;
  font-size: 2.5em;
  font-weight: bold;
}

.logo span {
  font-size: 0.9em;
  margin-left: 10px;
}

.search-section {
  display: flex;
  gap: 10px;
}

.search-input {
  padding: 8px 15px;
  border: none;
  border-radius: 20px;
  width: 300px;
  outline: none;
}

.search-btn {
  background: #fff;
  border: none;
  padding: 8px 15px;
  border-radius: 20px;
  cursor: pointer;
}

.user-section {
  font-size: 0.9em;
}
</style>