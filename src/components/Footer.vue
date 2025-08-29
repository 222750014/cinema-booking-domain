<template>
  <footer class="footer">
    <div class="footer-container">
      <div class="footer-section">
        <h4>General</h4>
        <ul>
          <li><a href="#" @click.prevent>Home</a></li>
          <li><a href="#" @click.prevent>About Us</a></li>
          <li><a href="#" @click.prevent>Contact</a></li>
          <li><a href="#" @click.prevent>Privacy Policy</a></li>
        </ul>
      </div>
      
      <div class="footer-section">
        <h4>Movies</h4>
        <ul>
          <li><a href="#" @click.prevent>Now Showing</a></li>
          <li><a href="#" @click.prevent>Coming Soon</a></li>
          <li><a href="#" @click.prevent>Trailers</a></li>
        </ul>
      </div>
      
      <div class="footer-section">
        <h4>Theaters</h4>
        <ul>
          <li><a href="#" @click.prevent>Find Theaters</a></li>
          <li><a href="#" @click.prevent>Premium Theaters</a></li>
        </ul>
      </div>
      
      <div class="footer-section">
        <h4>Help</h4>
        <ul>
          <li><a href="#" @click.prevent>FAQ</a></li>
          <li><a href="#" @click.prevent>Support</a></li>
          <li><a href="#" @click.prevent>Terms of Service</a></li>
        </ul>
      </div>
    </div>
    
    <div class="footer-bottom">
      <p>&copy; 2024 Tickets Booking Online. All rights reserved.</p>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'Footer'
}
</script>

<style scoped>
.footer {
  background: #333;
  color: white;
  padding: 40px 0 20px;
  margin-top: 50px;
}

.footer-container {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 40px;
  padding: 0 20px;
}

.footer-section h4 {
  color: #ffa500;
  margin-bottom: 20px;
  font-size: 1.1em;
}

.footer-section ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.footer-section li {
  margin-bottom: 10px;
}

.footer-section a {
  color: #ccc;
  text-decoration: none;
  transition: color 0.3s;
}

.footer-section a:hover {
  color: #ffa500;
}

.footer-bottom {
  border-top: 1px solid #555;
  margin-top: 30px;
  padding-top: 20px;
  text-align: center;
  color: #999;
}

@media (max-width: 768px) {
  .footer-container {
    grid-template-columns: repeat(2, 1fr);
    gap: 30px;
  }
}

@media (max-width: 480px) {
  .footer-container {
    grid-template-columns: 1fr;
    gap: 20px;
  }
}
</style>