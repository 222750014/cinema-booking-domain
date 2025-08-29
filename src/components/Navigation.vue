<template>
  <nav class="navigation">
    <div class="nav-container">
      <router-link to="/" class="nav-item" :class="{ active: $route.name === 'Home' }">
        HOME
      </router-link>
      <router-link to="/tickets" class="nav-item" :class="{ active: $route.name === 'Tickets' }">
        TICKETS
      </router-link>
      <router-link to="/movies" class="nav-item" :class="{ active: $route.name === 'Movies' }">
        MOVIES
      </router-link>
      <router-link to="/cinemas" class="nav-item" :class="{ active: $route.name === 'Cinemas' }">
        CINEMAS
      </router-link>
      <a href="#" class="nav-item">TRAILERS</a>
      <a href="#" class="nav-item">EVENTS & PROMOS</a>
      <a href="#" class="nav-item">ADVERTISE WITH US</a>
      <a href="#" class="nav-item">CONTACT US</a>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'Navigation'
}
</script>

<style scoped>
.navigation {
  background: #333;
  padding: 0;
}

.nav-container {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  gap: 0;
}

.nav-item {
  color: white;
  text-decoration: none;
  padding: 15px 20px;
  display: block;
  transition: background-color 0.3s;
  border-right: 1px solid #555;
}

.nav-item:hover,
.nav-item.active {
  background: #ff6b35;
}
</style>